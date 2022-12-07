package pl.coderslab.charity.dto;

import lombok.Data;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import javax.validation.constraints.NotNull;

@Data
public class CategoryDto {

    @NotNull
    private String name;

    public Category map(){
       Category category = new Category();
        category.setName(this.name);
        return category;
    }
}
