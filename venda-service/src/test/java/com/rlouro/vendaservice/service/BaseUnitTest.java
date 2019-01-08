package com.rlouro.vendaservice.service;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BaseUnitTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	protected static final Long ID_TEST = Long.valueOf(1);

}
