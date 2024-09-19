import java.text.NumberFormat;

public class InterestRateCalculator {

    public static void main(String[] args) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(3);
        // 贷款总额度
        int loanLimit = 50000;
        // 分期数量
        int stageNumber = 12;
        // 每月需还利息金额
        double interest = 146.9;
        // 每月需还款本金金额
        double moneyOfMonth = (double) loanLimit / stageNumber;
        // 理财收益率
        double yieldRate = 0.064;

        // 当月现金额
        double monthCount = loanLimit;

        /**
         * 计算每个月末的剩余现金
         *  若是最终月末现金大于0，则盈利，若小于0，则亏损
         */
        // 贷款的情况下 按照指定年利率理财来算:考虑月度复利
        for (int i = 1; i <= stageNumber; i++) {
            // 每个月的现金理财收益
            double mouthYield = monthCount * yieldRate / 12;
            // 当月现金 = 上个月结转现金 + 本月理财 - 本月应还利息- 本月应还本金
            monthCount = monthCount + mouthYield - interest - moneyOfMonth;
            // 若是最终月末现金大于0，则盈利，若小于0，则亏损
            System.out.println("第" + i + "个月末,月现金为：" + monthCount);
        }

        /**
         * 计算理财总收益来对比利息
         * 对比总利息和总营收，最终差额为正则盈利，为负则亏损
         */
        // 理财总收益 不需修改
        double countIncome = 0;
        System.out.println("按照" + yieldRate + "年利率理财来算:若考虑月度复利");
        // 当月现金额
        monthCount = loanLimit;
        for (int i = stageNumber; i > 0; i--) {
            double mouthYield = monthCount * yieldRate / 12;
            countIncome += mouthYield;
            System.out.println("第" + (stageNumber + 1 - i) + "个月,月收益为：" + mouthYield);
            // 总额减去每个月去掉的本金再加上当月产生的利益，因为需要复利
            monthCount = monthCount - moneyOfMonth - interest + mouthYield;

        }
        // 对比总利息和总营收，最终差额为正则盈利，为负则亏损
        System.out.println("最终总利息为：" + interest * stageNumber + "; 若将钱拿来用作" + yieldRate + "收益的投资，获取的收入为:" + countIncome + "; 差额：" + (countIncome - interest * stageNumber));
    }
}
