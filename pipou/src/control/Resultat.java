package control;

import java.util.HashMap;
import java.util.Map;

public class Resultat {
	private boolean res = false;
	private Map <String,String> err = new HashMap<String, String>();

	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}
	public Map<String, String> getErr() {
		return err;
	}
	public void setErr(Map<String, String> err) {
		this.err = err;
	}
	
	
}
