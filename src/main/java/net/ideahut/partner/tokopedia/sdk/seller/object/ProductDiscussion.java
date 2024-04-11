package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDiscussion {
	
	@JsonProperty("HasNext") 
    public Boolean hasNext;
    @JsonProperty("TotalQuestion") 
    public Integer totalQuestion;
    @JsonProperty("Question") 
    public ArrayList<Question> question;
    @JsonProperty("ProductID") 
    public Integer productID;
    @JsonProperty("ShopID") 
    public Integer shopID;
    @JsonProperty("ShopURL") 
    public String shopURL;

	public static class Answer {
	    @JsonProperty("Content") 
	    public String content;
	    @JsonProperty("MaskedContent") 
	    public String maskedContent;
	    @JsonProperty("UserName") 
	    public String userName;
	    @JsonProperty("UserThumbnail") 
	    public String userThumbnail;
	    @JsonProperty("UserID") 
	    public Integer userID;
	    @JsonProperty("CreateTime") 
	    public Date createTime;
	    @JsonProperty("CreateTimeFormatted") 
	    public String createTimeFormatted;
	    @JsonProperty("AttachedProduct") 
	    public ArrayList<AttachedProduct> attachedProduct;
	    @JsonProperty("LikeCount") 
	    public Integer likeCount;
	    @JsonProperty("AnswerID") 
	    public Integer answerID;
	    @JsonProperty("IsSeller") 
	    public Boolean isSeller;
	}

	public static class AttachedProduct {
	    @JsonProperty("ProductID") 
	    public Integer productID;
	    @JsonProperty("Name") 
	    public String name;
	    @JsonProperty("PriceFormatted") 
	    public String priceFormatted;
	    @JsonProperty("URL") 
	    public String uRL;
	    @JsonProperty("Thumbnail") 
	    public String thumbnail;
	}

	public static class Question {
	    @JsonProperty("Content") 
	    public String content;
	    @JsonProperty("MaskedContent") 
	    public String maskedContent;
	    @JsonProperty("UserName") 
	    public String userName;
	    @JsonProperty("UserID") 
	    public Integer userID;
	    @JsonProperty("CreateTime") 
	    public Date createTime;
	    @JsonProperty("CreateTimeFormatted") 
	    public String createTimeFormatted;
	    @JsonProperty("TotalAnswer") 
	    public Integer totalAnswer;
	    @JsonProperty("Answer") 
	    public ArrayList<Answer> answer;
	    @JsonProperty("QuestionID") 
	    public Integer questionID;
	    @JsonProperty("AnswererThumbnail") 
	    public String answererThumbnail;
	    @JsonProperty("UserThumbnail") 
	    public String userThumbnail;
	}
	
}
