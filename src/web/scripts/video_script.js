var video_exist = false;

function showVideo(){
	if(!video_exist){
		var contentBody = document.getElementById("content_body");
		var videoframe = document.createElement("iframe");
		videoframe.src = "https://www.youtube.com/embed/GCehKFkBePg";
		videoframe.setAttribute('allowFullScreen', '');
		videoframe.id = "video_frame";
		contentBody.appendChild(videoframe);
		video_exist = true;
	}else{
		var videoframe = document.getElementById("video_frame");
		videoframe.parentNode.removeChild(videoframe);
		video_exist = false;
	}
}