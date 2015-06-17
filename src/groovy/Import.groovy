import org.grails.plugins.excelimport.AbstractExcelImporter
import org.grails.plugins.excelimport.ExcelImportService

/**
 * Created by ace on 6/17/15.
 */
class Import extends AbstractExcelImporter {
    static Map CONFIG_BOOK_CELL_MAP = [
            sheet:'Sheet2',
            cellMap: [ 'D3':'Author',
                       'D4':'Book',
                       'D6':'numSold',
            ]
    ]

    static Map CONFIG_BOOK_COLUMN_MAP = [
            sheet:'Sheet1',
            startRow: 2,
            columnMap:  [
                    'A':'Author',
                    'B':'Book',
                    'C':'numSold',
            ]
    ]

    //can also configure injection in resources.groovy
    def getExcelImportService() {
        ExcelImportService.getService()
    }

    public Import(String file) {
        super(file)
    }

    List<Map> getBooks() {
        List bookList = excelImportService.columns(workbook, CONFIG_BOOK_COLUMN_MAP)
    }


    Map getOneMoreBookParams() {
        Map bookParams = excelImportService.cells(workbook, CONFIG_BOOK_CELL_MAP )
    }

    public static  void  main(String[] args) {
        println("test");
    }


}
