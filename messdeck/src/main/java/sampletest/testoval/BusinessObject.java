package sampletest.testoval;

import net.sf.oval.constraint.Assert;
import net.sf.oval.constraint.NotNull;

public class BusinessObject {

	@NotNull
	public String deliveryAddress;

	@NotNull
	public String invoiceAddress;

	// mailingAddress must either be the delivery address or the invoice address
	@Assert(expr = "_value ==_this.deliveryAddress || _value == _this.invoiceAddress", lang = "js")
	public String mailingAddress;

	public BusinessObject(String deliveryAddress, String invoiceAddress, String mailingAddress) {
		super();
		this.deliveryAddress = deliveryAddress;
		this.invoiceAddress = invoiceAddress;
		this.mailingAddress = mailingAddress;
	}
	
	

}