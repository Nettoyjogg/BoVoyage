package fr.adaming.serviceTest;

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
import fr.adaming.service.IVoyageService;

@RunWith(SpringJUnit4ClassRunner.class)//cette annotation sert � preciser que le lancement des tests 
//sera fait grace � la classe fourni par le module test de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VoyageServiceImplTest {

	
	@Autowired
	private IVoyageService vService;
	
	
	// ==================TEST LISTES VOYAGES
	//V�rifier la taille de la liste retourn�e
	@Test
	@Transactional(readOnly=true)
	public void testListeVoyage(){
		int tailleTheo=1;
		//r�cup�erer la taille de la liste
		int taillerelle=vService.afficherVoyages().size();
		
		assertEquals(tailleTheo, taillerelle);
	}
	
	//=====================Test Ajout Voyage
	//V�rifier que le voyage est bien ajout� � la liste des voyages
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testAjouterVoyage(){
		Voyage vIn = new Voyage();
		
		
		//r�cup�erer la taille de la liste avant l'ajout
		int taillerelle=vService.afficherVoyages().size();
		
		vService.ajouterVoyage(vIn);
		
		assertEquals(taillerelle+1, vService.afficherVoyages().size());
	
	}
	
	
	//V�rifier que l'ajout ne d�nature pas le voyage
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testAjouterVoyage1(){
		Destination dest = new Destination("Europe", "Maroc");
		Voyage vIn = new Voyage(10,null,null,300,true,dest,null,null);
		System.out.println(vIn);
		
		Voyage vOut=vService.ajouterVoyage(vIn);
		System.out.println(vOut);
		assertEquals(vIn, vOut);
	
	}
	

	
}
