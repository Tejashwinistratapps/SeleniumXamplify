package com.xamplify.LIVE;

import java.sql.SQLException;

public class CampaignMockTest {

	public static void main(String[] args) throws SQLException {
		Integer userId = 14824;
		VideoOpportunities vo = new VideoOpportunities();
		Integer campaignId = vo.getCampaignIdByCampaignNameAndCustomerId("campaign_emailg99_1569823808181", 19999);
		Integer videoId = vo.getVideoIdByCampaignId(campaignId);
		System.out.println("campaignId: "+campaignId);
		System.out.println("videoId: "+videoId);
		
		Integer result = vo.insertVideoAction(campaignId, videoId, userId);
		vo.insertEmailLog(campaignId, videoId, userId);

		System.out.println(result);
		
	}

}
