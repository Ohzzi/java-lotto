package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

//    @DisplayName("금액에 맞게 로또 티켓을 구입했는지 확인한다.")
//    @Test
//    void makeLottoTickets() {
//        PurchasingPrice purchasingPrice = new PurchasingPrice(3000);
//        int lottoTicketCounts = purchasingPrice.calculatePurchasableTicketCounts();
//        LottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
//
//        LottoTickets lottoTickets = LottoTickets.generateAutomatically(lottoTicketCounts, randomLottoNumberGenerator);
//
//        assertThat(lottoTickets.size()).isEqualTo(3);
//    }
//
//    @DisplayName("당첨 번호와 구매한 로또 티켓을 비교하여 결과를 반환한다.")
//    @Test
//    void getLottoResult() {
//        LottoNumberGenerator lottoNumberGenerator = () -> Arrays.asList(1, 2, 3, 4, 5, 6);
//        LottoTickets lottoTickets = LottoTickets.generateAutomatically(3, lottoNumberGenerator);
//        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7), 6);
//
//        LottoStatistics lottoStatistics = lottoTickets.getStatistics(winningLottoTicket);
//
//        assertThat(lottoStatistics.getCounts(LottoRank.SECOND)).isEqualTo(3);
//    }
//
//    @DisplayName("수동으로 로또 티켓을 산 결과를 반환한다.")
//    @Test
//    void makeManualLottoTickets() {
//        List<List<Integer>> numberGroup = new ArrayList<>();
//        numberGroup.add(Arrays.asList(1, 2, 3, 4, 5, 6));
//        numberGroup.add(Arrays.asList(7, 8, 9, 10, 11, 12));
//
//        LottoTickets lottoTickets = LottoTickets.generateManually(2, new ManualLottoNumberGenerator(numberGroup));
//
//        assertThat(lottoTickets.size()).isEqualTo(2);
//    }

    @DisplayName("수동 로또, 자동 로또 생성 테스트")
    @Test
    void makeLottoTickets() {
        PurchasingPrice purchasingPrice = new PurchasingPrice(5000);
        PurchasingCounts purchasingCounts = PurchasingCounts.of(purchasingPrice, 2);
        List<List<Integer>> numberGroup = new ArrayList<>();
        numberGroup.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        numberGroup.add(Arrays.asList(7, 8, 9, 10, 11, 12));

        LottoTickets lottoTickets = LottoTickets.generateLottoTickets(purchasingCounts, new ManualLottoNumberGenerator(numberGroup),
                new RandomLottoNumberGenerator());

        assertThat(lottoTickets.size()).isEqualTo(5);
    }
}