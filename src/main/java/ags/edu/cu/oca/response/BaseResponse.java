package ags.edu.cu.oca.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class BaseResponse {
    boolean ok;
    String msg;
    String error;
}
