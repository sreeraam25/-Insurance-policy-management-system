package com.client;
import java.sql.SQLException;
import java.util.*;
import com.service.CustomerService;
import com.exception.InvalidAllocationException;
import com.model.Allocation;
import com.model.Claim;
import com.model.Payment;
//import com.util.ApplicationUtil;
import com.model.Customer;
import com.model.Policy;
import com.service.*;
public class UserInterface {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InvalidAllocationException {
			try (Scanner sc = new Scanner(System.in)) {
				CustomerService cs=new CustomerService();
				PolicyService ps=new PolicyService();
				AllocationService as=new AllocationService();
				ClaimService css=new ClaimService();
				PaymentService pss=new PaymentService();
				System.out.println(" 𝙒𝙀𝙇𝘾𝙊𝙈𝙀 𝙏𝙊 𝙎𝙏𝘼𝙍 𝙇𝙄𝙁𝙀 𝙄𝙉𝙎𝙐𝙍𝘼𝙉𝘾𝙀 𝘾𝙊𝙈𝙋𝘼𝙉𝙔 \n");
				int category;
				do {
					System.out.println("1. 👤 𝘊𝘶𝘴𝘵𝘰𝘮𝘦𝘳 𝘔𝘰𝘥𝘶𝘭𝘦 👤\n2. 📋 𝘗𝘰𝘭𝘪𝘤𝘺 𝘔𝘰𝘥𝘶𝘭𝘦 📋\n3. 📲 𝘈𝘭𝘭𝘰𝘤𝘢𝘵𝘪𝘰𝘯 𝘔𝘰𝘥𝘶𝘭𝘦 📲\n4. 💰 𝘗𝘢𝘺𝘮𝘦𝘯𝘵𝘴 𝘔𝘰𝘥𝘶𝘭𝘦 💰\n5. 🎁 𝘊𝘭𝘢𝘪𝘮 𝘔𝘰𝘥𝘶𝘭𝘦 🎁\n6. ❌ 𝘌𝘹𝘪𝘵 ❌\n");
					System.out.println("Enter the Category ❗");
					 category=sc.nextInt();

					if(category==1) {
						while(true) {
							System.out.println("1.Register Customer\n2.Modify Details\n3.Data Retrieval\n4.Delete\n5.Exit");
							System.out.println("Enter the choice ❗");
							 int choice=sc.nextInt();
							sc.nextLine();
							
							if(choice==1) {
									System.out.println("Enter the number of customer ❗");
									int num=sc.nextInt();
									sc.nextLine();
									String[] cusArr=new String[num];
									try {
										
										System.out.println("Enter the customer details ❗");
										for(int i=0;i<num;i++) {
											cusArr[i]=sc.nextLine();
										}
										cs.addList(cusArr);
	
									
										int count=cs.addCustomercount();
	
										
										if(count>0) {
											System.out.println("🎉 Account has been created successfully 🎉");
										}
										else {
											System.out.println("Account has not been created");
										}
									}
									catch(ArrayIndexOutOfBoundsException e) {
										System.out.println("Please enter the details in this valid format ❗");
										System.out.println("Ravi Kumar:1988-03-15:33:Male:Software Developer:900000:No major medical history:Cityville:9876543210:ravi.kumar@example.com");
										
									}
							}
							if(choice==2) {
								System.out.println("Enter the Customer id ❗");
								String cusId=sc.next();
								System.out.println("1.Change Phone Number ☎ \n2.Change Email Id 📧");
								int change=sc.nextInt();
								if(change==1) {
									System.out.println("Enter the phone number to be updated ❗");
									long phno=sc.nextLong();
									boolean res=cs.customerRecordModificationPh(cusId,phno);
									if(res) {
										System.out.println("🎉 Phone number is updated Successfully 🎉");
									}
									else
									{
										System.out.println("Phone number is not updated");
									}
								}
								else if(change==2) {
									System.out.println("Enter the email id to be updated ❗");
									String email=sc.next();
									boolean res=cs.customerRecordModificationId(cusId,email);
									if(res) {
										System.out.println("🎉 Email ID is updated Successfully 🎉");
									}
									else
									{
										System.out.println("Email ID is not updated");
									}

								}
								else
								{
									System.out.println("Enter the valid key ❗");
									break;
								}
								
							}
							if(choice==3) {
								System.out.println("1.View all details 📒 \n2.View selected customer 📒");
								int details=sc.nextInt();
								
									if(details==1) {
										List<Customer> customer=cs.dataRetrievalAll();
										System.out.println("******👤******** CUSTOMER DETAILS ********👤******");
										for(Customer X:customer) {
									        System.out.print(X);
										}
									}
									else if(details==2) {
										System.out.println("Enter the customer id");
										String id=sc.next();
										List<Customer> customer=cs.dataRetrieval(id);
										System.out.println("******👤******** CUSTOMER DETAILS ********👤******");
										for(Customer X:customer) {
									        System.out.println(X);
										}
										
									}
									else {
										System.out.println("Enter valid key ❗");
										break;
									}
								
							}
							if(choice==4) {
								System.out.println("Enter the customer id ❗");
								String id=sc.next();
								boolean result=cs.delete(id);
								if(result) {
									System.out.println("🎉 Account deleted successfully 🎉");
								}
								else {
									System.out.println("Account is not Found");
								}
									
							}
							if(choice==5) {
								break;
							}
					
						}
					}
					else if(category==2) {
						
						while(true) {
							System.out.println("1.Policy Creation\n2.Policy Modification\n3.Data Retrieval\n4.Delete Policy\n5.Exit");
							System.out.println("Enter the choice ❗");
							 int choice=sc.nextInt();
							sc.nextLine();
							if(choice==1) {
								System.out.println("Enter the number of policy ❗");
								int num=sc.nextInt();
								sc.nextLine();
								String[] polArr=new String[num];
								System.out.println("Enter the policy details ❗");
								for(int i=0;i<num;i++) {
									polArr[i]=sc.nextLine();
								}
								ps.addList(polArr);
								int result=ps.addcount();
								if(result>0) {
									System.out.println(result+" Polices are inserted successfully 🎉");
								}
								else {
									System.out.println("Polices are not inserted");
								}
							}
							if(choice==2) {
								System.out.println("Enter the policy id ❗");
								String polId=sc.next();
								System.out.println("1.Change max sum assured\n2.Change max num of years");
								int change=sc.nextInt();
								if(change==1) {
									System.out.println("Enter the max sum assured to be updated ❗");
									int assured=sc.nextInt();
									boolean res=ps.policyRecordModification1(polId,assured);
									if(res) {
										System.out.println("🎉 Max sum is updated Sucessfully 🎉");
									}
									else
									{
										System.out.println("Max sum is not updated");
									}
								}
								else if(change==2) {
									System.out.println("Enter the max num of years to be upadted ❗");
									int years=sc.nextInt();
									boolean res=ps.policyRecordModificationId2(polId,years);
									if(res) {
										System.out.println("🎉 Max num of years is updated Sucessfully 🎉");
									}
									else
									{
										System.out.println("Max num of years is not updated");
									}

								}
								else
								{
									System.out.println("Enter the valid key ❗");
									break;
								}
								
								
							}
							if(choice==3) {
								System.out.println("!!!📋!!! POLICY DETAILS !!!!📋!!!");
								List<Policy> policy=ps.dataRetrievalAll();
								for(Policy x:policy) {
									System.out.println(x);
								}
								
							}
							if(choice==4) {
								System.out.println("Enter the policy id ❗");
								String polId=sc.next();
								boolean result=ps.delete(polId);
								if(result) {
									System.out.println("🎉 Policy deleted successfully 🎉");
								}
								else {
									System.out.println("Policy is not Found");
								}
								break;
								
						
							}
							if(choice>=5) {
								break;
							}
							
						}
					}
					if(category==3) {
						while(true) {
							System.out.println("1.Allocation Creation\n2.Data Retrieval\n3.Delete\n4.Exit");
							int choice=sc.nextInt();
							
							if(choice==1) {
								System.out.println("Enter the Customer id ❗");
								String cusid=sc.next();
								if(cs.checkValidId(cusid)) {
									System.out.println("Enter the Policy id ❗");
									String polid=sc.next();
									if(ps.checkValidId1(polid)) {
										System.out.println("Enter the Allocation details ❗");
										sc.nextLine();

										System.out.println("Enter the nominee name ❗");
										String nominee_name=sc.nextLine();
										
										System.out.println("💸 Enter payment cycle 💸\n1.Half-year\n2.Yearly");
										int cycle=sc.nextInt();
										as.calculatePremiumAmount(cusid,polid,nominee_name,cycle);
										boolean a=as.allocationCreation();
										if(a) {
											System.out.println("🎉 Allocation created successfully 🎉");
										}
										else {
											System.out.println("Allocation is not created");
										}
									}
									else {
										System.out.println("Please enter a valid Policy id ❗");
									}
								}
								else {
									System.out.println("Please enter a valid customer id ❗");
								}
							}
							
							if(choice==2) {
								System.out.println("--------💾-------- ALLOCATION DETAILS --------💾--------");
								System.out.println("1.View all details 📒\n2.View selected customer 📒");
								int details=sc.nextInt();
								if(details==1) {
									List<Allocation> al=as.dataRetrievalAll();
									System.out.println("Allocation Details");
									for(Allocation x:al) {
										System.out.println(x);
									}
								}
								else if(details==2) {
									System.out.println("Enter the Allocation Id ❗");
									String id=sc.next();
									List<Allocation> al=as.dataRetrieval(id);
									System.out.println("Allocation Details");
									for(Allocation x:al) {
										System.out.println(x);
									}
									
								}
								else {
									System.out.println("Enter valid key ❗");
									break;
								}
							}
							if(choice==3)
							{
								System.out.println("Enter the Allocation id ❗");
								String allId=sc.next();
								boolean result=as.delete(allId);
								if(result) {
									System.out.println("🎉 Allocation deleted successfully 🎉");
								}
								else {
									System.out.println("Allocation is not Found");
								}
								break;
								
								
							}
							if(choice==4) {
								break;
							}
					
						}
				}
				if(category==4){
					while(true) {
						System.out.println("1.Payments\n2.Data Retrival\n3.Exit");
						int choice=sc.nextInt();
						if(choice==1) {
							System.out.println("Enter the Customer id ❗");
							String cusid=sc.next();
							if(as.checkValidId1(cusid)) {
								System.out.println("Enter the allocation id ❗");
								String allocid=sc.next();
								if(as.checkValidId(allocid)) {
									System.out.println("Enter Your Payment Type 💰\n1.UPI 🆙 \n2.CARD 💳");
									int type=sc.nextInt();
									if(type==1) {
										System.out.println("Enter the UPI ID 🆙");
										String id=sc.next();
										if(pss.upidValid(id)) {
										System.out.println("Enter your Phone Number 📞");
										long ph=sc.nextLong();
										double d=pss.paymentCreation(cusid,allocid,type);
										boolean r=pss.addPayment();
										String transId=pss.generateTransactionId();
										if(r) {
											System.out.println("---------------🧾️ RECEIPT 🧾️---------------");
											System.out.println("Customer Id: "+cusid);
											System.out.println("Transaction Id: "+transId);
											System.out.println("Phone Number: "+ph);
											System.out.println("You paid-"+d+"\nPayment successfull 🎉" );
										}
										else {
											System.out.println("---------------🧾️ RECEIPT 🧾️---------------");
											System.out.println("Payment is declined");
										}
										}
										else {
											System.out.println("Please provide a valid id ❗");
										}
									}
									
									else if(type==2) {
										sc.nextLine();
										System.out.println("Enter the card number 💳");
										String cardid=sc.nextLine();
										if(pss.cardValid(cardid)) {
											System.out.println("Enter your Phone Number 📞");
											long ph=sc.nextLong();
											double d=pss.paymentCreation(cusid,allocid,type);
											boolean r=pss.addPayment();
											String transId=pss.generateTransactionId();
											if(r) {
												System.out.println("---------------🧾️ RECEIPT 🧾️---------------");
												System.out.println("Customr Id: "+cusid);
												System.out.println("Transaction Id: "+transId);
												System.out.println("Phone Number: "+ph);
												System.out.println("You paid-"+d+"\nPayment successfull 🎉" );
									
											}
											else {
												System.out.println("---------------🧾️ RECEIPT 🧾️---------------");
												System.out.println("Payment is declined");
											}
										}
										else {
											System.out.println("Please provide a valid card details ❗");
										}
										
									}
									else {
										System.out.println("please enter a valid Payment type ❗");
									}
									
								}
								else {
									System.out.println("Please enter a valid allocation id ❗");
								}
							}
							else {
								System.out.println("Please enter a valid customer id ❗");
							}
						}
						if(choice==2) {
							List<Payment> pay= pss.getData();
							System.out.println("------💲--------PAYMENT DETAILS------💲--------");
							for(Payment X:pay) {
								System.out.println(X);
							}
							
							
						}
						if(choice>=3) {
							break;	
						}
													
						}
				}
				if(category==5) {
					while(true) {System.out.println("1.Claim creation\n2.Data retrieval\n3.Deletion\n4.Exit");
					int choice=sc.nextInt();

					if(choice==1) {
						System.out.println("Enter the Customer id ❗");
						String cusid=sc.next();
						List<Allocation> al=as.dataRetrievalC(cusid);
						if(!al.isEmpty()) {
							System.out.println("Allocation Details");
							for(Allocation x:al) {
								System.out.println(x);
							}
							System.out.println("Enter the allocation id");
							String allocid=sc.next();
							if(as.checkValidId(allocid)) {
								System.out.println("Enter the claim type");
								String claimType=sc.next();
								if(claimType.equalsIgnoreCase("Death")) {
									css.claimCreation(cusid,allocid,claimType);
								}
								else if(claimType.equalsIgnoreCase("Maturity")) {
									css.claimCreation(cusid,allocid,claimType);
									}
								else if(claimType.equalsIgnoreCase("Survival benefit")){
									css.claimCreation(cusid,allocid,claimType);
									
								}
								else {
									System.out.println("Please enter a valid claims\nif claim available only \nDeath\nMaturity\nSurvival benefit");
								}
								
								double a=css.addClaim();
								if(a!=0) {
									System.out.println("Your claim is apporved amount is "+a);
								}
								else {
									System.out.println("Your claim is not apporved");
								}
								
							}
							else {
								System.out.println("Please enter a valid allocation id ❗");
							}
						}
						else {
							System.out.println("Please enter a valid customer id ❗");
						}
					}
					if(choice==2)
					{
						List<Claim> claim= css.getData();
						System.out.println("------🎁-------CLAIM DETAILS-------🎁------");
						for(Claim X:claim) {
							System.out.println(X);
						}
					}
					if(choice==3) {
						System.out.println("Enter the Claim id ❗");
						String claimId=sc.next();
						boolean result=css.delete(claimId);
						if(result) {
							System.out.println("🎉 Claim was deleted successfully 🎉");
						}
						else {
							System.out.println("Claim Not Found");
						}
						break;
					}
					if(choice>=4) {
						break;
					}}
					
				}
				if(category==6) {
					System.out.println("💗 𝐓𝐇𝐀𝐍𝐊𝐒 𝐅𝐎𝐑 𝐂𝐇𝐎𝐎𝐒𝐈𝐍𝐆 𝐒𝐓𝐀𝐑 𝐋𝐈𝐅𝐄 𝐈𝐍𝐒𝐔𝐑𝐀𝐍𝐂𝐄 💗"); 
					break;
				}
			}while(category<6);
		}
				
	}
			
}
























