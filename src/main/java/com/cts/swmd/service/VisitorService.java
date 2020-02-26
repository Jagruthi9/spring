package com.cts.swmd.service;

import com.cts.swmd.exception.InvalidVisitorException;
import com.cts.swmd.model.Visitor;

public interface VisitorService {
	boolean isValid(Visitor visitor)throws InvalidVisitorException;
	Visitor computeAge(Visitor visitor);

}
