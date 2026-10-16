package br.com.kaiserraf.spring_boot_essentials.controller;

import br.com.kaiserraf.spring_boot_essentials.database.models.ProdutoModel;
import br.com.kaiserraf.spring_boot_essentials.dto.ProdutoDto;
import br.com.kaiserraf.spring_boot_essentials.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/Produtos")
// para o @RequiredArgsContructor funcionar
// a classe que está tendo a injeção de dependência precisa
// ser um Bean. Por exemplo a service: ela tem um @Service
// em cima da classe, o que faz ela virar um Bean
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService _produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAll(){
        List<ProdutoModel> listaProdutos = _produtoService.findAll();
        return new ResponseEntity<>(listaProdutos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> postProduto(@RequestBody ProdutoDto produtoDto){
        ProdutoModel newProduto = _produtoService.newProduto(produtoDto);
        return new ResponseEntity<>(newProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> putProduto(@PathVariable Integer id, @RequestBody ProdutoDto produtoDto){
        ProdutoModel putProduto = _produtoService.putProduto(id, produtoDto);
        return new ResponseEntity<>(putProduto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Integer id){
        _produtoService.deleteProduto(id);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }
}
