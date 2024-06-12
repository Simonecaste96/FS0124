import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PostInterface } from 'src/app/models/post-interface';
import { PostsServiceService } from 'src/services/posts-service.service';

@Component({
  selector: 'app-new-post-page',
  templateUrl: './new-post-page.component.html',
  styleUrls: ['./new-post-page.component.scss'],
})
export class NewPostPageComponent implements OnInit {
  newPostForm!: FormGroup;

  constructor(
    private postService: PostsServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.newPostForm = new FormGroup({
      postTitle: new FormControl(null, Validators.required),
      postBody: new FormControl(null, Validators.required),
    });
  }

  onSubmit() {
    const postTitle = this.newPostForm.get('postTitle')?.value;
    const postBody = this.newPostForm.get('postBody')?.value;

    const newPost: PostInterface = {
      title: postTitle,
      body: postBody,
    };

    this.postService.createPost(newPost).subscribe((data) => {
      const postId = data.name;
      console.log(postId);
      newPost.id = postId;
      console.log(newPost);

      this.postService.updatePost(newPost, postId).subscribe(() => {
        alert('Post creato correttamente');
        this.router.navigate(['/posts']);
      });
    });
  }
}
