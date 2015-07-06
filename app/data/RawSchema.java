package data;

import java.util.ArrayList;
import java.util.List;

import interfaces.IRawSchema;

public class RawSchema implements IRawSchema {

	@Override
	public List<String> GetAllSchemasList() {
		List<String> lsRes=new ArrayList<String>();
		lsRes.add("RawSchema1");
		lsRes.add("RawSchema2");
		lsRes.add("RawSchema3");
		lsRes.add("RawSchema4");
		lsRes.add("RawSchema5");
		return lsRes;
	}
	public List<String> GetXML() {
		List<String> lsRes=new ArrayList<String>();
		lsRes.add("11111");
		lsRes.add("22222");
		lsRes.add("33333");
		lsRes.add("44444");
		lsRes.add("55555");
		return lsRes;
	}

	@Override
	public String GetSchema(String SchemaName) {
		
		String res="<?xml version='1.0' encoding='UTF-8' standalone='no'?>"
				+ "<Event>"
				+ "<SystemID/>"
				+ "<SessionID/>"
				+ "<EventID/>"
				+ "<StartTimeUTC/>"
				+ "<EndTimeUTC/>"
				+ "<Duration/>"
				+ "<EventTypeID/><ChannelTypeID/><IsAnonymous/><Master_PTN/><Master_BAN/><IVR_App_Description/><IVR_App_Pattern_Ind/><IVR_Back_End_Data/><IVR_Call_Identifier/><IVR_Option_Timestamp/><IVR_RefData_App_Sequence_Number/><IVR_RefData_Application_Description/><IVR_RefData_Application_ID/><IVR_RefData_Back_End_Call_Sequence/><IVR_RefData_Back_End_Error_Number/><IVR_RefData_Back_End_Request_Number/><IVR_RefData_Back_End_Sequence_Number/><IVR_RefData_Back_End_Success_YN_Flag/><IVR_RefData_Brand/><IVR_RefData_Completion_YN_Flag/><IVR_RefData_Menu_Description/><IVR_RefData_Menu_ID/><IVR_RefData_Menu_Sequence_Number/><IVR_RefData_Option_Description/><IVR_RefData_Option_ID/><LayerID/><PhysicalID/><PhysicalCustomerID/><LogicalEvents/><OriginalEventID_String/><IVR_Menu_Description_String/><OriginalSessionID_String/></Event>";
		return res;
	}

}
