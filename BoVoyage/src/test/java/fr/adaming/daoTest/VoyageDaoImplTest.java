package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;

@RunWith(SpringJUnit4ClassRunner.class)//cette annotation sert � preciser que le lancement des tests 
//sera fait grace � la classe fourni par le module test de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VoyageDaoImplTest {

	
	@Autowired
	private IVoyageDao voyageDao;
		
	//=====================Test Ajout Voyage
	//V�rifier que le voyage est bien ajout� � la liste des voyages
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testAjouterVoyage(){
		Voyage vIn = new Voyage();
		
		
		//r�cup�erer la taille de la liste avant l'ajout
		int taillerelle=voyageDao.afficherVoyages().size();
		
		voyageDao.ajouterVoyage(vIn);
		
		assertEquals(taillerelle+1, voyageDao.afficherVoyages().size());
	
	}
	
	
	//V�rifier que l'ajout ne d�nature pas le voyage
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testAjouterVoyage1(){
		Destination dest = new Destination("Europe", "Maroc");
		Voyage vIn = new Voyage(10,null,null,300,true,dest,null,null);
		System.out.println(vIn);
		
		Voyage vOut=voyageDao.ajouterVoyage(vIn);
		System.out.println(vOut);
		assertEquals(vIn, vOut);
	
	}
	
	//=====================Test Modifier Voyage
		//V�rifier que la modification s'effectue bien avec le bon nombre d'it�ration
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testModifierVoyage(){
		Destination dest = new Destination("Europe", "Maroc");
		Voyage v1 = new Voyage(10,null,null,300,true,dest,null,null);
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println(v1);
		voyageDao.ajouterVoyage(v1);
		v1.setPrix(400);
		int verif=voyageDao.modifierVoyage(v1);
		System.out.println(v1);
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println(verif);
		assertEquals(verif, 1);
	
	}
	//=====================Test Ajout Voyage
	//V�rifier que le voyage est bien ajout� � la liste des voyages
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testRechercherVoyage(){
		Destination dest = new Destination("Europe", "Maroc");
		Voyage v1 = new Voyage(1,10,null,null,300,true,dest,null,null);
		voyageDao.ajouterVoyage(v1);
		Voyage v2 = voyageDao.rechercherVoyage(v1);
		
		assertEquals(v1,v2);
	
	}
	
}
