package br.com.rodrigo.restapi.resources;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.restapi.models.Produto;
import br.com.rodrigo.restapi.models.dao.ProdutoDao;

@RestController
public class ProdutoResource {

	@CrossOrigin
	@GetMapping("/produtos")
	public List<Produto> findAll() {
		List<Produto> produtos = new ProdutoDao().findAll();
		return produtos;
	}
	
	@CrossOrigin
	@PostMapping("/produtos")
	public boolean addNewProduto(@RequestBody Produto produto) {
		ProdutoDao prodDao = new ProdutoDao();
		if (prodDao.save(produto)) {
			return true;
		}
		return false;
	}
	
	@CrossOrigin
	@GetMapping("/produtos/{id}")
	public Produto findProduto(@PathVariable(name = "id") Integer id) {
		ProdutoDao prodDao = new ProdutoDao();
		return prodDao.findByPK(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/produtos/{id}")
	public boolean removeProduto(@PathVariable("id") Integer id) {
		ProdutoDao prodDao = new ProdutoDao();
		if (!prodDao.remove(id)) {
			return false;
		}
		return true;
	}
	
	@CrossOrigin
	@PostMapping("/produtos/update")
	public boolean updateProduto(@RequestBody Produto produto) {
		ProdutoDao prodDao = new ProdutoDao();
		if (!prodDao.update(produto)) {
			return false;
		}
		return true;
	}
}
