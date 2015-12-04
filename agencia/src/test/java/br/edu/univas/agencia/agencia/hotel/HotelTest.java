package br.edu.univas.agencia.agencia.hotel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;
import br.edu.univas.agencia.agencia.dao.CityDAO;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.hotel.HotelDAO;
import br.edu.univas.agencia.hotel.HotelService;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Hotel;

public class HotelTest {
	
	public HotelTest(){
		
	}
	
	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 *
	 */
	@Test
	public void testCreateHotel(){
		try{
			System.out.println("starting method create Hotel");
			Hotel hotel = null;
			HotelService hservice = new HotelService();
			Hotel expectResult = null;
			Hotel result = hservice.createHotel(hotel);
			assertEquals(expectResult, result);
			System.out.println("Test createRestaurant method finish...");
		} catch (AgencyException e) {
			fail("Test fail. Cause: " + e.getMessage());
		}
	}
	
	@Test
	public void listHotels()throws AgencyException{
		ArrayList<Hotel> hotels=new ArrayList<Hotel>();
		ArrayList<Hotel> resp=new ArrayList<Hotel>();
		EntityManager em=HibernateUtil.getEntityManager();
		HotelDAO dao=new HotelDAO(em);
		hotels=(ArrayList<Hotel>) dao.getAll();
		for (Hotel hotel : hotels) {
			System.out.println("nome: "+hotel.getNome());
			resp.add(hotel);
		}
		assertEquals(hotels, resp);
	}
	@SuppressWarnings("null")
	@Test
	public void saveHotel(){
		EntityManager em=HibernateUtil.getEntityManager();
		HotelDAO dao=new HotelDAO(em);
		Hotel gravar=null;
		Hotel resp=null;
		CityDAO cDAO=new CityDAO();
		Cidade citEsc=null;
		Integer id = 0;
		String procuraCidade="Pouso Alegre";
		ArrayList<Cidade> cidades=(ArrayList<Cidade>) cDAO.getAll(em);
		ArrayList<Hotel> hotels=(ArrayList<Hotel>) dao.getAll();
		for (Cidade cidade : cidades) {
			System.out.println("nome: "+cidade.getNome());
			if(cidade.getNome().equals(procuraCidade)){
				id=(Integer)cidade.getId();
			}
		}
		citEsc=cDAO.getById(id, em);
		gravar.setNome("teste-1");
		gravar.setCidade(citEsc);
		gravar.setNumeroVagas(50);
		gravar.setValor(99);
		gravar.setActive(true);
		
		dao.salvar(gravar);
		
		for (Hotel hotel : hotels) {
			if(hotel.getNome().equals(gravar.getNome())){
				resp=hotel;
			}
		}
		assertEquals(resp, gravar);
	}
	
	@Test
	public void testFindHotels(){
		ArrayList<Hotel> hotels=new ArrayList<Hotel>();
		ArrayList<Hotel> listaInternaHotel=new ArrayList<Hotel>();
		EntityManager em=HibernateUtil.getEntityManager();
		HotelDAO dao=new HotelDAO(em);
		String procurar="teste-1.5";
		Integer id = null;
		Hotel resp;
		hotels=(ArrayList<Hotel>) dao.getAll();
		for (Hotel hotel : hotels) {
			System.out.println("nome: "+hotel.getNome());
			if(hotel.getNome().equals(procurar)){
				id=(Integer)hotel.getId();
			}
			listaInternaHotel.add(hotel);
		}
		System.out.println("id de "+procurar+": "+id);
		resp=dao.getById(id);
		assertEquals(resp.getNome(), procurar);
		
	}
	
	@Test
	public void testDeleteHotels(){
		EntityManager em=HibernateUtil.getEntityManager();
		HotelDAO dao=new HotelDAO(em);
		Hotel gravar=null;
		Hotel resp=null;
		Integer id = 0;
		String procuraHotel="teste-1.5";
		ArrayList<Hotel> hotels=(ArrayList<Hotel>) dao.getAll();
		
		for (Hotel hotel : hotels) {
			if(hotel.getNome().equals(procuraHotel)){
				id=hotel.getId();
//				dao.delete(hotel);//era para ser assim mas pela lógica do negócio apenas tem que trocar por inativo...
				gravar=dao.getById(id);
				gravar.setActive(false);
				dao.update(gravar);
				resp=gravar;
			}
		}
		assertEquals(resp, gravar);
	}
	
	@Test
	public void testActivateHotels(){
		EntityManager em=HibernateUtil.getEntityManager();
		HotelDAO dao=new HotelDAO(em);
		Hotel gravar=null;
		Hotel resp=null;
		Integer id = 0;
		String procuraHotel="teste-1.5";
		ArrayList<Hotel> hotels=(ArrayList<Hotel>) dao.getAll();
		
		for (Hotel hotel : hotels) {
			if(hotel.getNome().equals(procuraHotel)){
				id=hotel.getId();
//				dao.delete(hotel);//era para ser assim mas pela lógica do negócio apenas tem que trocar por inativo...
				gravar=dao.getById(id);
				gravar.setActive(true);
				dao.update(gravar);
				resp=gravar;
			}
		}
		assertEquals(resp, gravar);
	}
	@Test
	public void testListAvailableHotels(){
		
	}
	
	@Test
	public void testHotelReport(){
		
	}

}








