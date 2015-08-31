package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the POST database table.
 * 
 */
@Entity
@Table(name="Post", schema="SYSTEM")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(schema="SYSTEM", name="SEQ_POSTID", sequenceName="SEQ_POSTID",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_POSTID")
	@Column(name="POST_ID")
	private long postId;

	@Column(name="POST_CONTENT")
	private String postContent;

	@Temporal(TemporalType.DATE)
	@Column(name="POST_DATE")
	private Date postDate;

	//bi-directional many-to-one association to Bulluser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Bulluser bulluser;

	public Post() {
	}

	public long getPostId() {
		return this.postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return this.postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Bulluser getBulluser() {
		return this.bulluser;
	}

	public void setBulluser(Bulluser bulluser) {
		this.bulluser = bulluser;
	}

}