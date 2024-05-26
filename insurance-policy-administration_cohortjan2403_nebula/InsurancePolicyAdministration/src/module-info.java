///**
// * 
// */
///**
// * @author Do3
// *
// */
//module InsurancePolicyAdministration {
//	requires java.sql;
//}
//											System.out.println("CUSTOMER_ID : " + X.getCustomerId()+"\t");
//									        System.out.println("CUSTOMER_NAME : " + X.getCustomerName()+"\t");
//									        System.out.println("DOB : " + X.getDob()+"\t");
//									        System.out.println("AGE : " + X.getAge()+"\t");
//									        System.out.println("GENDER : " + X.getGender()+"\t");
//									        System.out.println("OCCUPATION : " + X.getOccupation()+"\t");
//									        System.out.println("ANNUAL_INCOME : " + X.getAnnualIncome()+"\t");
//									        System.out.println("MEDICAL_HISTORY : " + X.getMedicalHistory()+"\t");
//									        System.out.println("ADDRESS : " + X.getAddress()+"\t");
//									        System.out.println("PHONE_NUMBER : " + X.getPhoneNumber()+"\t");
//									        System.out.println("EMAIL_ID : " + X.getEmailId()+"\t");


//public boolean validId1(String id) throws SQLException {
//		Connection con=DBConnectionManager.getConnection();
//		String query="select * from Allocation where CUSTOMER_ID=? ";
//		PreparedStatement p=con.prepareStatement(query);
//		p.setString(1, id);
//		ResultSet rs=p.executeQuery();
//		if(rs.next()) {
//			return true;
//		}
//		return false;
//	}