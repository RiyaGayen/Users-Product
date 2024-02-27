package org.jsp.userproduct.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.userproduct.UsersProducctConfiguration;
import org.jsp.userproduct.dao.ProductDao;
import org.jsp.userproduct.dao.UsersDao;
import org.jsp.userproduct.dto.Product;
import org.jsp.userproduct.dto.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
		static ProductDao pdao;
		static UsersDao mdao;
		static ApplicationContext context;
		static Scanner sc = new Scanner(System.in);
		static {
			context = new AnnotationConfigApplicationContext(UsersProducctConfiguration.class);
			pdao = context.getBean(ProductDao.class);
			mdao = context.getBean(UsersDao.class);

		}

		public static void main(String[] args) {
			while (true) {
				System.out.println("1. SaveUsers");
				System.out.println("2. UpdateUsers");
				System.out.println("3. FindUsersById");
				System.out.println("4. VerifyUsersByPhone");
				System.out.println("5. VerifyUsersByEmail");
				System.out.println("6. AddProduct");
				System.out.println("7. UpdateProduct");
				System.out.println("8. FindProductByUsersId");
				System.out.println("9. FindProductByBrand");
				System.out.println("10. FindProductByCatagory");
				System.out.println("11.  FindProductByUsersPhoneAndPassword()");
				

				switch (sc.nextInt()) {
				case 1:
					SaveUsers();
					break;
				case 2:
					UpdateUsers();
					break;
				case 3:
					FindUsersById();
					break;
				case 4:
					VerifyUsersByPhone();
					break;
				case 5:
					VerifyUsersByEmail();
					break;
				case 6:
					AddProduct();
					break;
				case 7:
					UpdateProduct();
					break;
				case 8:
					FindProductByUsersId();
					break;
				case 9:
					FindProductByBrand();
					break;
				case 10:
					FindProductByCatagory();
					break;
				case 11:
					FindProductByUsersPhoneAndPassword();
					 break;
				default:
					System.out.println("Invalid Option");
				}
			}
		}

		private static void FindProductByUsersId() {
			System.out.println("Enter Users id");
			int id=sc.nextInt();
			List<Product> p=((ProductDao) pdao).FindProductByUsersId(id);
			if(p.size()>0) {
				for(Product x:p) {
					System.out.println(x.getName());
					System.out.println(x.getBrand());
					System.out.println(x.getCategory());
				}
				
			}
			
			
		}
		private static void FindProductByUsersPhoneAndPassword() {
			System.out.println("Enter Users phone and Password");
			long phone=sc.nextLong();
			String password=sc.next();
			
			List<Product> p=((ProductDao) pdao).FindProductByUsersPhoneAndPassword(phone,password);
			if(p.size()>0) {
				for(Product x:p) {
					System.out.println(x.getName());
					System.out.println(x.getBrand());
					System.out.println(x.getCategory());
				}
				
			}
			
			
		}
		private static void FindProductByBrand() {
			System.out.println("Enter Brand ");
			String brand=sc.next();
			List<Product> p=((ProductDao) pdao).FindProductByBrand(brand);
			if(p.size()>0) {
				for(Product x:p) {
					System.out.println(x.getName());
					System.out.println(x.getBrand());
					System.out.println(x.getCategory());
				}
				
			}
			
			
		}
		private static void FindProductByCatagory() {
			System.out.println("Enter Catagory ");
			String catagory=sc.next();
			List<Product> p=((ProductDao) pdao).FindProductByCatergory(catagory);
			if(p.size()>0) {
				for(Product x:p) {
					System.out.println(x.getName());
					System.out.println(x.getBrand());
					System.out.println(x.getCategory());
				}
				
			}
			
			
		}


		private static void UpdateProduct() {
			System.out.println("Enter Id, name,brand,category,description,Cost");
			Product p= new Product();
			p.setId(sc.nextInt());
			p.setName(sc.next());
			p.setBrand(sc.next());
			p.setCategory(sc.next());
			p.setDescription(sc.next());
			p.setCost(sc.nextDouble());
			p=pdao.UpdateProduct(p);
			if(p!=null) {
				System.out.println("Product Updated");
			}else {
				System.out.println("Cannot Update Product");
			}
			

		}

		private static void AddProduct() {
			System.out.println("Enter users ID");
			int id = sc.nextInt();
			System.out.println("Enter name,brand,category,description,Cost");
			Product p = new Product();
			p.setName(sc.next());
			p.setBrand(sc.next());
			p.setCategory(sc.next());
			p.setDescription(sc.next());
			p.setCost(sc.nextDouble());
			p = pdao.AddProduct(p, id);
			if (p != null) {
				System.out.println("Product Saved With id : " + p.getId());
			} else {
				System.out.println("Not Saved");
			}

		}

		private static void SaveUsers() {
			System.out.println("Enter Username,phone,email,Password to Save");
			Users m = new Users();
			m.setName(sc.next());
			m.setPhone(sc.nextLong());
			m.setEmail(sc.next());
			m.setPassword(sc.next());

			m = mdao.saveUsers(m);
			if (m != null) {
				System.out.println("User Saved With id : " + m.getId());
			} else {
				System.out.println("Not Saved");
			}
		}

		private static void UpdateUsers() {
			System.out.println("Enter Id,Username,phone,email,Password to Save");
			Users m = new Users();
			m.setId(sc.nextInt());
			m.setName(sc.next());
			m.setPhone(sc.nextLong());
			m.setEmail(sc.next());
			m.setPassword(sc.next());
			m = mdao.updateUsers(m);
			if (m != null) {
				System.out.println("User Updated ");
			} else {
				System.out.println("Not Updated");
			}

		}

		private static void FindUsersById() {
			System.out.println("Enter Id");
			int id = sc.nextInt();
			Users m = new Users();
			m = mdao.FindUsers(id);
			if (m != null) {
				System.out.println(m.getName());
				System.out.println(m.getEmail());
				System.out.println(m.getPhone());
				System.out.println(m.getPassword());

			} else {
				System.out.println("Invalid Id");
			}

		}
		

		private static void VerifyUsersByPhone() {
			System.out.println("Enter phone Number And Password");
			long phone = sc.nextLong();
			String password = sc.next();
			Users m = new Users();
			m = mdao.VerifyUsers(phone, password);
			if (m != null) {
				System.out.println(m.getName());
				System.out.println(m.getEmail());
				System.out.println(m.getPhone());
				System.out.println(m.getPassword());
			} else {
				System.out.println("Invalid Number or Password");
			}

		}

		private static void VerifyUsersByEmail() {
			System.out.println("Enter phone email And Password");
			String email = sc.next();
			String password = sc.next();
			Users m = new Users();
			m = mdao.VerifyUsers(email, password);
			if (m != null) {
				System.out.println(m.getName());
				System.out.println(m.getEmail());
				System.out.println(m.getPhone());
				System.out.println(m.getPassword());
			} else {
				System.out.println("Invalid Number or Password");
			}

		

		
	}

}
