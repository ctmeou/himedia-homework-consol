package com.homework.consol;

import java.util.List;

public interface CategoryMapper {
    List<CategoryDTO> selectAllRestaurant();

    List<CategoryDTO> searchCategoryBySupRestaurant(SearchCriteria searchCriteria);

    int insertCategory(CategoryDTO category);

    int updateCategory(CategoryDTO category);

    int deleteCategory(int code);
}
