package com.src.facade;



import com.src.entities.*;
import com.src.repository.ProdutoRepository;
import com.src.repository.UsuarioRepository;
import com.src.repository.VendaRepository;
import com.src.repository.impl.ProdutoRepositoryImpl;
import com.src.repository.impl.UsuarioRepositoryImpl;
import com.src.repository.impl.VendaRepositoryImpl;
import com.src.service.impl.ProdutoServiceImpl;
import com.src.service.impl.UsuarioServiceImpl;
import com.src.service.impl.VendaServiceImpl;
import java.util.List;

public class SistemaVendasFacade {
    private ProdutoServiceImpl produtoServiceImpl;
    private UsuarioServiceImpl usuarioServiceImpl;
    private VendaServiceImpl vendaServiceImpl;

    public SistemaVendasFacade() {
        ProdutoRepository produtoRepo = new ProdutoRepositoryImpl();
        UsuarioRepository usuarioRepo = new UsuarioRepositoryImpl();
        VendaRepository vendaRepo = new VendaRepositoryImpl();
        this.produtoServiceImpl = new ProdutoServiceImpl(produtoRepo);
        this.usuarioServiceImpl = new UsuarioServiceImpl(usuarioRepo);
        this.vendaServiceImpl = new VendaServiceImpl(vendaRepo, produtoRepo);
    }

    // Produto CRUD
    public void createProduto(Produto produto) {
        produtoServiceImpl.createProduto(produto);
    }

    public Produto getProduto(Integer id) {
        return produtoServiceImpl.getProduto(id);
    }

    public List<Produto> getAllProdutos() {
        return produtoServiceImpl.getAllProdutos();
    }

    public void updateProduto(Produto produto) {
        produtoServiceImpl.updateProduto(produto);
    }

    public void deleteProduto(Integer id) {
        produtoServiceImpl.deleteProduto(id);
    }

    // Usuario CRUD
    public void createUsuario(Usuario usuario) {
        usuarioServiceImpl.createUsuario(usuario);
    }

    public Usuario getUsuario(int id) {
        return usuarioServiceImpl.getUsuario(id);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioServiceImpl.getAllUsuarios();
    }

    public void updateUsuario(Usuario usuario) {
        usuarioServiceImpl.updateUsuario(usuario);
    }

    public void deleteUsuario(int id) {
        usuarioServiceImpl.deleteUsuario(id);
    }

    // Venda CRUD
    public void createVenda(Venda venda) {
        vendaServiceImpl.createVenda(venda);
    }

    public Venda getVenda(int id) {
        return vendaServiceImpl.getVenda(id);
    }

    public List<Venda> getAllVendas() {
        return vendaServiceImpl.getAllVendas();
    }

    public void updateVenda(Venda venda) {
        vendaServiceImpl.updateVenda(venda);
    }

    public void deleteVenda(int id) {
        vendaServiceImpl.deleteVenda(id);
    }
}
