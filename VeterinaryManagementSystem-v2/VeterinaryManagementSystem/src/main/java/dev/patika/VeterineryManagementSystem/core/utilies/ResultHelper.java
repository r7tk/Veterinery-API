package dev.patika.VeterineryManagementSystem.core.utilies;

import dev.patika.VeterineryManagementSystem.core.result.Result;
import dev.patika.VeterineryManagementSystem.core.result.ResultData;
import dev.patika.VeterineryManagementSystem.dto.response.CursorResponse;
import org.springframework.data.domain.Page;

public class ResultHelper {
    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED, "201", data);
    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(true, Msg.OK, "208", data);
    }

    public static Result NotFoundError(String msg) {
        return new Result(true, Msg.VALIDATE_ERROR, "404");
    }

    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData) {
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }
}



