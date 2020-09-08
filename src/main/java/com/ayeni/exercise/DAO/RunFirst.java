package com.ayeni.exercise.DAO;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ayeni.exercise.interfaces.CardSchemeRepository;
import com.ayeni.exercise.models.CardScheme;


public class RunFirst {
	CardSchemeRepository cardSchemeRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void saveCardScheme() {
		String[] banks = { "UBS", "FCMD", "" };
		String[] schemes = { "visa", "mastercard", "amex" };
		String[] cards = { "4166676667666746", "4646464646464644", "5136333333333335", "4017340000000003",
				"5585558555855583", "5555444433331111", "2222410740360010", "5555555555554444", "2222410700000002",
				"2222400010000008", "2223000048410010", "2222400060000007", "2223520443560010", "5500000000000004",
				"6771798025000004", "5100705000000002", "5106040000000008", "4000620000000007", "4000060000000006",
				"4000180000000002" };

		for (int i = 0; i < 20; i++) {
			cardSchemeRepository.save(new CardScheme(cards[i], schemes[(int) Math.random() * 3], "debit",
					banks[(int) Math.random() * 3], 0));
		}
	}
}
