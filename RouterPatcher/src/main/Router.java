package main;

/**
 * Created by will on 20/01/17.
 * 
 * Router Object
 */
public class Router
{

	private String hostname;

	private String ipAddress;

	private boolean patched;

	private float osSystem;

	private String notes;

	public String getHostname()
	{
		return hostname;
	}

	public void setHostname(String hostname)
	{
		if (hostname != null)
		{
			hostname = hostname.toLowerCase();
		}
		this.hostname = hostname;
	}

	public String getIpAddress()
	{
		return ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		if (ipAddress != null)
		{
			ipAddress = ipAddress.toLowerCase();
		}
		this.ipAddress = ipAddress;
	}

	public boolean isPatched()
	{
		return patched;
	}

	public void setPatched(boolean patched)
	{
		this.patched = patched;
	}

	public float getOsSystem()
	{
		return osSystem;
	}

	public void setOsSystem(float osSystem)
	{
		this.osSystem = osSystem;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	@Override
	public String toString()
	{
		String router = "";
		router = getHostname() + " (" + getIpAddress() + "), OS version " + getOsSystem();

		if (getNotes() != null && getNotes() != "")
		{
			router += " [" + getNotes() + "]";
		}

		return router;
	}

}
