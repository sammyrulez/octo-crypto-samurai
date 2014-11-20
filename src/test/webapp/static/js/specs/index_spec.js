describe("Stock Portfolio App Tests", function() {
  it("calcSideFundInterest() should return a value that is greater than the supplied fund value.", function() {
    var calcSideFundInterest = function(fundValue, dailyInt, period) {
      return fundValue + (fundValue * (dailyInt * period));
    };
    var fundValue = 1000,
        dailyInt  = 0.00356,
        period    = 7;
    var result = calcSideFundInterest(fundValue, dailyInt, period);
    expect(result).toBeGreaterThan(fundValue);
  });
});
