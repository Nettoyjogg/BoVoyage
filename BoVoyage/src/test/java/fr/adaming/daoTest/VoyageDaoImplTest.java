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

@RunWith(SpringJUnit4ClassRunner.class)//cette annotation sert à preciser que le lancement des tests 
//sera fait grace à la classe fourni par le module test de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VoyageDaoImplTest {

	
	@Autowired
	private IVoyageDao voyageDao;
	
	
	// ==================TEST LISTES VOYAGES
	//Vérifier la taille de la liste retournée
	@Test
	@Transactional(readOnly=true)
	public void testListeVoyage(){
		int tailleTheo=1;
		//récupéerer la taille de la liste
		int taillerelle=voyageDao.afficherVoyages().size();
		
		assertEquals(tailleTheo, taillerelle);
	}
	
	//=====================Test Ajout Voyage
	//Vérifier que le voyage est bien ajouté à la liste des voyages
	@Test
	@Transactional
	@Rollback(true)//Des que le test est terminé la base de donnée doit revenir à son état initial
	public void testAjouterVoyage(){
		Voyage vIn = new Voyage();
		
		
		//récupéerer la taille de la liste avant l'ajout
		int taillerelle=voyageDao.afficherVoyages().size();
		
		voyageDao.ajouterVoyage(vIn);
		
		assertEquals(taillerelle+1, voyageDao.afficherVoyages().size());
	
	}
	
	
	//Vérifier que l'ajout ne dénature pas le voyage
	@Test
	@Transactional
	@Rollback(true)//Des que le test est terminé la base de donnée doit revenir à son état initial
	public void testAjouterVoyage1(){
		Destination dest = new Destination("Europe", "Maroc");
		Voyage vIn = new Voyage(10,null,null,300,true,dest,null,null);
		System.out.println(vIn);
		
		Voyage vOut=voyageDao.ajouterVoyage(vIn);
		System.out.println(vOut);
		assertEquals(vIn, vOut);
	
	}
	

	
}
