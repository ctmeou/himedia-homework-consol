package com.homework.consol;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService = new CategoryService();

    public void selectAllRestaurant() {

        List<CategoryDTO> restaurantList = categoryService.selectAllRestaurant();

        if (restaurantList != null) {
            restaurantList.forEach(System.out::println);
        } else {
            System.out.println("전체 조회에 실패했습니다.");
        }
    }
    public void registRestaurant(Map<String, String> parameter) {
        int areaCode = Integer.parseInt(parameter.get("areaCode"));
        String name = parameter.get("name");
        String type = parameter.get("type");
        String step = parameter.get("step");
        String menu = parameter.get("menu");

        CategoryDTO category = new CategoryDTO();
        category.setAreaCode(areaCode);
        category.setName(name);
        category.setType(type);
        category.setStep(step);
        category.setMenu(menu);

        if (categoryService.registRestaurant(category)) {
            System.out.println("\n신규 식당이 등록되었습니다.");
        } else {
            System.out.println("\n식당 등록에 실패했습니다.");
        }
    }

    public void updateRestaurant(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        int areaCode = Integer.parseInt(parameter.get("areaCode"));
        String name = parameter.get("name");
        String type = parameter.get("type");
        String step = parameter.get("step");
        String menu = parameter.get("menu");

        CategoryDTO category = new CategoryDTO();
        category.setCode(code);
        category.setAreaCode(areaCode);
        category.setName(name);
        category.setType(type);
        category.setStep(step);
        category.setMenu(menu);

        if (categoryService.updateRestaurant(category)) {
            System.out.println("\n식당 정보 수정을 완료했습니다.");
        } else {
            System.out.println("\n식당 정보 수정을 실패했습니다.");
        }
    }

    public void delectRestaurant(Map<String, String> paramter) {
        int code = Integer.parseInt(paramter.get("code"));

        if (categoryService.deleteRestaurant(code)) {
            System.out.println("\n식당 삭제를 완료했습니다.");
        } else {
            System.out.println("\n식당 삭제를 실패했습니다.");
        }

    }
}
