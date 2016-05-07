package com.app.messdeck.customvalidations;

import net.sf.oval.constraint.CheckWithCheck;

public class IsVendorExists implements CheckWithCheck.SimpleCheck {

	@Override
	public boolean isSatisfied(Object validatedObject, Object value) {

		return false;
	}

}
