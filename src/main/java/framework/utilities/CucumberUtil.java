package framework.utilities;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import cucumber.api.DataTable;

import java.util.List;

public class CucumberUtil {

    private static Table<String, Integer, DataCollection> _dataCollection
            = HashBasedTable.create();

    public static Table<String, Integer, DataCollection> ConvertDataTableToDict(DataTable table) {
        List<List<String>> data = table.raw();

        int rowNumber = 0;

        for (List<String> col : data) {
            for (int colIndex = 0; colIndex < col.size(); colIndex++) {

                _dataCollection
                        .put(data.get(0).get(colIndex), rowNumber, new DataCollection(data.get(0).get(colIndex), col.get(colIndex), rowNumber));
            }

            rowNumber++;
        }

        return _dataCollection;

    }

    //ToDo: Passing the rowIndex to get the columnValue based on Row number
    public static String GetCellValue(String columnName, int rowNumber) {
        int counter = 0;

        for (Table.Cell<String, Integer, DataCollection> cell : _dataCollection.cellSet()) {

            if (counter == rowNumber) {

                return _dataCollection.get(columnName, counter).ColumnValue;
            }

            counter++;
        }

        return null;
    }

    private static class DataCollection {
        private String ColumnName;
        private String ColumnValue;
        private int RowNumber;

        public DataCollection(String columnName, String columnValue, int rowNumber) {
            ColumnName = columnName;
            ColumnValue = columnValue;
            RowNumber = rowNumber;
        }
    }

}




