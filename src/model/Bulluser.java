package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BULLUSER database table.
 * 
 */
@Entity
@Table(name="BULLUSER", schema="TESTDB")
@NamedQuery(name="Bulluser.findAll", query="SELECT b FROM Bulluser b")
public class Bulluser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@SequenceGenerator(schema="TESTDB", name="SEQ_BULLUSERID", sequenceName="SEQ_BULLUSERID",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_BULLUSERID")
	@Column(name="USER_ID")
	private long userId;

	private String email;

	@Column(name="FULL_NAME")
	private String fullName;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="JOINDATE")
	private Date joinDate;
	
	@Column(name="MOTTO")
	private String motto;
	
	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="bulluser")
	private List<Post> posts;

	public Bulluser() {
	}

	public String getMotto()
	{
		return motto;
	}

	public void setMotto(String motto)
	{
		this.motto = motto;
	}

	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}
	public Date getJoinDate()
	{
		return this.joinDate;
	}
	
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setBulluser(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setBulluser(null);

		return post;
	}

}