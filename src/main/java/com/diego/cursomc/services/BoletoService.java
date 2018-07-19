/**
 * @author Diego Adriano - diegoadricandido23@gmail.com
 * @since 17 de jul de 2018
 *
 */
package com.diego.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.diego.cursomc.domain.PagamentoComBoleto;

/**
 * @author diego
 *
 */
@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Date instantePedido) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(instantePedido);
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		pgto.setDataVencimento(calendar.getTime());
	}
}
