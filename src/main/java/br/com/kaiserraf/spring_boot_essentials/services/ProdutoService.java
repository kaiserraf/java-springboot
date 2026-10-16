package br.com.kaiserraf.spring_boot_essentials.services;

import br.com.kaiserraf.spring_boot_essentials.dto.ProdutoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.kaiserraf.spring_boot_essentials.database.models.*;

/// Todas as anotações que são colocadas nas classes são Beans,
/// classes que  serão gerenciadas automaticamente pelo próprio Spring Boot.
/// Toda anotação por baixo dos panos é um @Component
@Service
public class ProdutoService {
    private static final List<ProdutoModel> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoModel.builder()
                 .id(1)
                 .name("Notebook")
                 .preco(new BigDecimal("5000"))
                 .quantidade(10)
                 .build());
        PRODUTOS.add(ProdutoModel.builder()
                 .id(2)
                 .name("Iphone")
                 .preco(new BigDecimal("7000"))
                 .quantidade(10)
                 .build());
        PRODUTOS.add(ProdutoModel.builder()
                 .id(3)
                 .name("Mouse")
                 .preco(new BigDecimal("500"))
                 .quantidade(10)
                 .build());
    }

    public List<ProdutoModel> findAll(){
        return new ArrayList<>(PRODUTOS);
    }

    // newProduto
    public ProdutoModel newProduto(ProdutoDto produtoDto){

        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoModel::getId)
                .max()
                .orElse(0) + 1;

        ProdutoModel novoProduto = ProdutoModel.builder()
                .id(identificador)
                .name(produtoDto.getName())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);

        return novoProduto;
    }

    // editProduto
    public ProdutoModel putProduto(Integer id, ProdutoDto produtoDto){
        ProdutoModel produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setName(produtoDto.getName());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    // deleteProduto
    public void deleteProduto(Integer id){
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }
}
