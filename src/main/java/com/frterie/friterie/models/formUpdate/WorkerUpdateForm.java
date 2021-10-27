package com.frterie.friterie.models.formUpdate;

import com.frterie.friterie.models.dto.PurchaseMiniDTO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.List;

@Data
@Validated
public class WorkerUpdateForm {

    @Length(min = 4, max = 12)
    private String name;

    @Length(min = 4, max = 12)
    private String username;

    @Min(8)
    private String password;

    private List<Integer> deliveryID;

}
