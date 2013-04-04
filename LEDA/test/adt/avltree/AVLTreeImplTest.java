//package adt.avltree;
//
//import static org.junit.Assert.*;
//import junit.framework.Assert;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//@RunWith(JUnit4.class)
//public class AVLTreeImplTest {
//
//	private AVLTree<Integer> avl;
//	
//	@Before
//	public void setUp(){
//		avl = new AVLTreeImpl<Integer>();
//	}
//	
//	@Test
//	public void testInitialState(){	
//		Assert.assertTrue("Root should be empty!", avl.getRoot().isEmpty());
//		assertEquals("Altura deveria ser -1!", -1, avl.height());
//		
//		Comparable[] array = new Comparable[0];
//		
//		assertEquals("error pre order!", array,avl.preOrder());
//		assertEquals("error post order! ", array,avl.postOrder());
//		
//	}
//	
//	public void testInsertion(){
//		avl.insert(10);
//		assertEquals("size should be 1", 1, avl.size());
//		avl.insert(20);
//		assertEquals("size should be 2", 2 , avl.size());
//		
////		assertEquals("size should be 1", 0, avl.inserir(15));
////		assertEquals("Nao inseriu 5", 0, avl.inserir(5));
////		assertEquals("Nao inseriu 30", 0, avl.inserir(30));
////				
////		assertNotNull("Raiz deveria ser diferente de null", avl.getRaiz());
////		assertEquals("Altura deveria ser 3",3, avl.getAltura(avl.getRaiz()));
////		assertEquals("Percurso em pre-ordem errado.", "15 10 5 20 30",avl.percorrePreOrdem());
////		assertEquals("Percurso em pos-ordem errado.", "5 10 30 20 15",avl.percorrePosOrdem());
////		
////		avl.inserir(17);
////		
////		assertNotNull(avl.getRaiz());
////		assertEquals("Altura deveria ser 3", 2, avl.getAltura(avl.getRaiz()));
////		assertEquals("Percurso em pre-ordem errado.", "15 10 5 20 17 30",avl.percorrePreOrdem());
////		assertEquals("Percurso em pos-ordem errado.", "5 10 17 30 20 15",avl.percorrePosOrdem());
////		
////		avl.inserir(35);
////		avl.inserir(40);
////		
////		assertNotNull(avl.getRaiz());
////		assertEquals("Altura deveria ser 4", 5, avl.getAltura(avl.getRaiz()));
////		assertEquals("Percurso em pre-ordem errado.", "15 10 5 20 17 35 30 40",avl.percorrePreOrdem());
////		assertEquals("Percurso em pos-ordem errado.", "5 10 17 30 40 35 20 15",avl.percorrePosOrdem());
////		
////	}
//		
//	}
//	/*
//	public void testInsertionLimiteCondition(){		
//		avl.inserir(10);
//		avl.inserir(20);
//		avl.inserir(15);
//		avl.inserir(5);
//		avl.inserir(30);
//		avl.inserir(17);
//		
//		//tenta inserir valor negativo
//		assertEquals("Nao deveria ter inserido.", -1,avl.inserir(-10));
//		//tenta inserir valor repetido
//		assertEquals("Nao deveria ter inserido.", -1,avl.inserir(10));
//		
//		assertNotNull(avl.getRaiz());
//		assertEquals("Altura deveria ser 3",3, avl.getAltura(avl.getRaiz()));
//		assertEquals("Percurso em pre-ordem errado.", "15 10 5 20 17 30",avl.percorrePreOrdem());
//		assertEquals("Percurso em pos-ordem errado.", "5 10 17 30 20 15",avl.percorrePosOrdem());
//		
//	}
//	
//
//
//	public void testHeight(){
//		avl.inserir(10);
//		avl.inserir(20);
//		avl.inserir(15);
//		avl.inserir(5);
//		
//		assertEquals("Altura deveria ser 3",3, avl.getAltura(avl.getRaiz()));
//		assertEquals("Altura deveria ser 1",0, avl.getAltura(avl.getRaiz().getDireita()));
//		assertEquals("Altura deveria ser 2",2, avl.getAltura(avl.getRaiz().getEsquerda()));
//		
//	}
//
//	public void testSearch(){
//		avl.inserir(10);
//		avl.inserir(20);
//		avl.inserir(15);
//		avl.inserir(5);
//		avl.inserir(30);
//		avl.inserir(17);
//		
//		assertTrue("Deveria ter achado 20.",avl.pesquisar(20));
//		assertTrue("Deveria ter achado 15.",avl.pesquisar(15));
//	}
//	
//
//	public void testSearchLimiteCondition(){
//		avl.inserir(10);
//		avl.inserir(20);
//		avl.inserir(15);
//		avl.inserir(5);
//		avl.inserir(30);
//		avl.inserir(17);	
//
//		//pesquisa valor inexistente
//		assertFalse("Nao deveria ter achado 40",avl.pesquisar(40));
//	}
//*/
//}
