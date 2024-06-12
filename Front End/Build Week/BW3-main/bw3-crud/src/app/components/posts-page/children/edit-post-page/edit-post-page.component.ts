import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PostInterface } from 'src/app/models/post-interface';
import { PostsServiceService } from 'src/services/posts-service.service';

@Component({
  selector: 'app-edit-post-page',
  templateUrl: './edit-post-page.component.html',
  styleUrls: ['./edit-post-page.component.scss'],
})
export class EditPostPageComponent implements OnInit {
  currentPost!: PostInterface;
  editPostForm!: FormGroup;
  id!: string;

  constructor(
    private postSrv: PostsServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
      this.postSrv.getPost(this.id).subscribe((data) => {
        this.currentPost = data;
        this.initForm();
      });
    });
  }

  initForm(): void {
    this.editPostForm = new FormGroup({
      postTitle: new FormControl(this.currentPost?.title, Validators.required),
      postBody: new FormControl(this.currentPost?.body, Validators.required),
    });
  }

  onSubmit() {
    const postTitle = this.editPostForm.get('postTitle')?.value;
    const postBody = this.editPostForm.get('postBody')?.value;

    const updatedPost: PostInterface = {
      title: postTitle,
      body: postBody,
      id: this.currentPost.id,
    };

    this.postSrv.updatePost(updatedPost, this.id).subscribe(() => {
      alert('Post modificato con successo');
      this.router.navigate(['/posts']);
    });
  }

  deletePost(id: string) {
    this.postSrv.deletePost(id).subscribe(() => {
      alert('Post eliminato con successo');
      this.router.navigate(['/posts']);
    });
  }
}
