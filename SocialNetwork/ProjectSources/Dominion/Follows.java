package Dominion;


import java.sql.SQLException;


public class Follows {
	
	private String follower_mail;
	private String followed_mail;
	
	
	public Follows(String follower_mail, String followed_mail) throws SQLException{
		this.follower_mail=follower_mail;
		this.followed_mail=followed_mail;
	}
	
	public Follows(){
		
	}

	
	public String getFollower_mail() {
		return follower_mail;
	}

	public void setFollower_mail(String follower_mail) {
		this.follower_mail = follower_mail;
	}

	public String getFollowed_mail() {
		return followed_mail;
	}

	public void setFollowed_mail(String followed_mail) {
		this.followed_mail = followed_mail;
	}

	@Override
	public String toString() {
		return "Follows [Follower=" + follower_mail + ", Followed=" + followed_mail + "]\n";
	}
}