package com.example.continuada3.repository;
import com.example.continuada3.dominio.Certidao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CertidoesRepository extends  JpaRepository<Certidao,String> {

    // este dynamic finder consulta todos os esportes cujo id da categoria for igual ao valor do parâmetro
    List<Certidao> findByCartorioId(Integer idCartorio);

    // este método faria exatamente a mesma consulta do findByCategoriaId(), porém com JPQL parametrizado
    //@Query("select e from Esporte e where e.categoria.id = ?1")
  //  List<Esporte> pesquisarPorCategoria(Integer idCategoria);
    /*
    No JPQL podemos incluir parâmetros, começando a contagem do 1.
    No exemplo acima, o '?1' será substituído pelo primeiro parâmetro do método (idCategoria)
    Com o uso desses parâmetros não nos preocupamos com aspas nem conversões (ex: campos de data)
     */

    /*  /// outra maneira de usar parâmetros
    @Query("select e from Esporte e where e.categoria.id = :id")
    List<Esporte> pesquisarPorCategoria2(@Param("id") Integer idCategoria);
    */

    //@Query("select e from Esporte e where e.categoria.id in (?1)")
  //  List<Esporte> pesquisarPorCategorias(List<Integer> idsCategoria);
    // List<Esporte> pesquisarPorCategorias(Integer[] idsCategoria);
    // List<Esporte> pesquisarPorCategorias(Integer... idsCategoria);

}
