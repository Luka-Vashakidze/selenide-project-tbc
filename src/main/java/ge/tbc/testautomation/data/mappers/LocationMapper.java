package ge.tbc.testautomation.data.mappers;

import ge.tbc.testautomation.data.models.LocationTestData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {

    @Select("SELECT id, area, expected_min_results as expectedMinResults FROM location_test_data")
    List<LocationTestData> getAllLocationTestData();

}
