package ge.tbc.testautomation.dataprovider;

import ge.tbc.testautomation.data.mappers.LocationMapper;
import ge.tbc.testautomation.data.models.LocationTestData;
import ge.tbc.testautomation.util.MyBatisUtil;
import org.testng.annotations.DataProvider;

import java.util.List;

public class LocationDataProvider {

    @DataProvider(name = "locationDataFromDb")
    public static Object[][] locationDataProvider() {
        LocationMapper mapper = MyBatisUtil.getMapper(LocationMapper.class);
        List<LocationTestData> testDataList = mapper.getAllLocationTestData();

        Object[][] data = new Object[testDataList.size()][2];
        for (int i = 0; i < testDataList.size(); i++) {
            data[i][0] = testDataList.get(i).getArea();
            data[i][1] = testDataList.get(i).getExpectedMinResults();
        }
        return data;
    }
}
