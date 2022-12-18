package com.midterm.midterm.Food;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@RestController
public class FoodController {
    private Map<Integer, Food> foodList = new HashMap<Integer, Food>();

    public FoodController() {
        Food order = new Food();
        order.setOrderNum(1);
        order.setFoodName("BLT");
        order.setCalories(344);
        order.setFat(17.5);
        order.setCarbs(34.9);
        foodList.put(1, order);

        Food order2 = new Food();
        order2.setOrderNum(2);
        order2.setFoodName("Chicken");
        order2.setCalories(335);
        order2.setFat(5);
        order2.setCarbs(0);
        foodList.put(2, order2);
    }

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ResponseEntity<List<Food>> getFood(@RequestParam(value = "orderNum", defaultValue = "0") int orderNum) {
        // Collection<Food> results = foodList.values();
        List<Food> response = new ArrayList<>();

        switch(orderNum){
            case 0://all food on the list
                response = new ArrayList<>(foodList.values());
                break;
            default://specific food
                Food found = new Food();
                found = foodList.get(orderNum);
                if(found == null){
                    response.add(new Food(orderNum, "No food here", 0, 0, 0));
                    return new ResponseEntity<List<Food>>(response, HttpStatus.NOT_FOUND);
                } else {
                    response.add(foodList.get(orderNum));
                }
                break;
        }//end switch

        return new ResponseEntity<List<Food>>(response, HttpStatus.OK);
    }
    //@RequestBody Food food
    @RequestMapping(value = "/food", method = RequestMethod.POST)
    public ResponseEntity<Food> postReservation(@RequestParam(value = "orderNum") int orderNum, @RequestParam(value = "foodName") String foodName, @RequestParam(value = "calories") int calories, @RequestParam(value = "fat") double fat, @RequestParam(value = "carbs") double carbs) {
        ObjectMapper mapper = new ObjectMapper();
        
        Food response = new Food(0, "empty", 0, 0, 0);

        if (foodList.get(orderNum) != null) {
            // food is not empty
            response = new Food(orderNum, "There is already food here, cannot add a new order", 0, 0, 0);
            return new ResponseEntity<Food>(response, HttpStatus.NOT_FOUND);
        }

        Food order = new Food();
        order.setOrderNum(orderNum);
        order.setFoodName(foodName);
        order.setCalories(calories);
        order.setFat(fat);
        order.setCarbs(carbs);
        foodList.put(orderNum, order);
        response = foodList.get(orderNum);

        return new ResponseEntity<Food>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/food", method = RequestMethod.PUT)
    public ResponseEntity<Food> putReservation(@RequestParam(value = "orderNum") int orderNum, @RequestParam(value = "sauce") String sauce) {
        Food response = new Food(0, "empty", 0, 0, 0);

        if (foodList.get(orderNum) == null) {
            // food is empty
            response = new Food(orderNum, "There is no food, cannot add a sauce", 0, 0, 0);
            return new ResponseEntity<Food>(response, HttpStatus.NOT_FOUND);
        }

        //check if sauce is empty
        if(sauce == null || sauce.isEmpty()){
            response = new Food(orderNum, "There is no sauce, cannot add a sauce", 0, 0, 0);
            return new ResponseEntity<Food>(response, HttpStatus.NOT_FOUND);
        }

        //check if sauce is already on the food
        if(foodList.get(orderNum).getFoodName().contains(sauce)){
            response = new Food(orderNum, "There is already sauce on the food, cannot add a sauce", 0, 0, 0);
            return new ResponseEntity<Food>(response, HttpStatus.NOT_FOUND);
        }
        

        String originalFood = foodList.get(orderNum).getFoodName();
        foodList.get(orderNum).setFoodName(originalFood + " and " + sauce);
        response = foodList.get(orderNum);


        return new ResponseEntity<Food>(response, HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/food", method = RequestMethod.DELETE)
    public ResponseEntity<Food> deleteReservation(@RequestParam(value = "orderNum") int orderNum) {
        Food response = new Food(0, "empty", 0, 0, 0);

        if (foodList.get(orderNum) == null) {
            // food is empty
            response = new Food(orderNum, "There is no food, cannot delete the order", 0, 0, 0);
            return new ResponseEntity<Food>(response, HttpStatus.NOT_FOUND);
        }
        
        foodList.remove(orderNum);
        response.setOrderNum(orderNum);
        response.setFoodName("deleted");

        return new ResponseEntity<Food>(response, HttpStatus.OK);
    }
}
