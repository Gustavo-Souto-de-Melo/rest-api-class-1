package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Produto;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    //SELECT DISTINCT(NOME) FROM PRODUTO;
    Produto findDistinctNomeBy();

    //SELECT * FROM PRODUTO ORDER BY PRECO DESC LIMIT 3;
    List<Produto> findTop3ByPreco();

    //SELECT * FROM PRODUTO WHERE NOME = 'NOME'
    List<Produto> findByNomeEqualsIgnoreCase(String nome);
    List<Produto> findByNomeIsNot(String nome);
    List<Produto> findByPedidosIsNotNull();
    List<Produto> findByAtivoTrue();
    //SELECT * FROM PRODUTO WHERE NOME LIKE 'NARG%'
    List<Produto> findByNomeStartingWith(String prefix); //narg
    //SELECT * FROM PRODUTO WHERE NOME LIKE '%NARG'
    List<Produto> findByNomeEndingWith(String suffix); //narg

    //SELECT * FROM PRODUTO WHERE NOME LIKE '%arguil%'
    List<Produto> findByNomeContaining(String infix); //arguil
    List<Produto> findByNomeLikeIgnoreCase(String pattern); //a%v%c
    List<Produto> findByPrecoBetween(BigDecimal min, BigDecimal max);
    List<Produto> findByNomeIn(List<String> nomes); //NOME IN (SELECT...)
    List<Produto> findByExpiracaoBefore(LocalDate dataExpiracao);
    List<Produto> findByEstoqueExists
}