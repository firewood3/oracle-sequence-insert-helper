package gchsj.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Code {
    private String type;
    private String code;
    private String codeSeq;
}
