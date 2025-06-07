import { Component,OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
// import { RouterOutlet } from "@angular/router";

import{Produto} from './models/produto';
import {ProdutoService} from './services/produto.service';

@Component({
  selector: 'app-root',
  standalone:true,
  imports:[
    CommonModule,
    FormsModule,
    // RouterOutlet
  ],
  templateUrl: './app.component.html',
  styleUrls:['./app.component.css']
})
export class AppComponent implements OnInit{

  produtos: Produto[] = [];
  produtoParaAdicionar: Produto = {nome:'', preco:0,medida:'',categoria: '',marca:''}
  constructor(private produtoService: ProdutoService){}

  ngOnInit(): void {
    this.carregarProdutos();
  }


 carregarProdutos(): void {
  this.produtoService.listarProdutos().subscribe((dados: Produto[]) => { // <--- PROBLEMA AQUI
    this.produtos = dados;
  });
}

  onSubmit(): void {
    this.produtoService.adicionarProduto(this.produtoParaAdicionar).subscribe({
      next: (produtoAdicionado:Produto) => {
        alert(`Produto "${produtoAdicionado.nome}" adicionado com sucesso!`);
        this.carregarProdutos();
        this.produtoParaAdicionar = { nome: '', preco: 0, medida: '', categoria: '', marca: '' };
      },
      error: (err:any) => {
        alert('Falha ao adicionar o produto.');
      }
    });
  }
}