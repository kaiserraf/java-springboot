package br.com.kaiserraf.spring_boot_essentials.database.models;

import jdk.jshell.Snippet;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoModel {
    private Integer id;
    private String name;
    private BigDecimal preco;
    private Integer quantidade;
}
