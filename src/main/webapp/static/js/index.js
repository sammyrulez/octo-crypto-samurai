function bindCurrentQuote(){
    	 data = {quote : 123, currency: 'Euro' , trend : 1.2};
    	 var trendCssClass = 'bg-info';
    	 if(data['trend'] > 0){
    		 trendCssClass = 'bg-success';
    	 }
    	 if(data['trend'] < 0){
    		 trendCssClass = 'bg-error';
    	 }
    	 data['trendCssClass'] = trendCssClass
    	 $('#quote').loadTemplate($("#quoteTemplate"),data);
}
