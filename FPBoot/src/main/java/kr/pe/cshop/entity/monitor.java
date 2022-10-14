package kr.pe.cshop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class monitor {
    @Id
    private String sn;
    private String brand;
    private String name;
    private String price;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" 고유번호 : ");
        builder.append(sn);
        builder.append(" 제조사 : ");
        builder.append(brand);
        builder.append(" 제품명 : ");
        builder.append(name);
        builder.append(" 가격 : ");
        builder.append(price);
        return builder.toString();
    }
}

