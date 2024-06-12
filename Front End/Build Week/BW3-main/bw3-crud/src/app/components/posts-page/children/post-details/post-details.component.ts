import { Component, OnInit } from '@angular/core';
import { PostInterface } from 'src/app/models/post-interface';
import { PostsServiceService } from 'src/services/posts-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.scss'],
})
export class PostDetailsComponent implements OnInit {
  post!: PostInterface;
  id!: string;

  constructor(
    private postSrv: PostsServiceService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
    });
    this.getPostDetails();
  }

  getPostDetails() {
    if (this.id) {
      this.postSrv.getPost(this.id).subscribe((data) => {
        console.log(data);

        this.post = data;
      });
    }
  }
}
