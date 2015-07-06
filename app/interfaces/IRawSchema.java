package interfaces;

import java.util.List;

public interface IRawSchema {
	public List<String> GetAllSchemasList();
	public String GetSchema(String SchemaName);
}
