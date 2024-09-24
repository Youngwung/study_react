import React from 'react';
import { createSearchParams, useNavigate, useParams, useSearchParams } from 'react-router-dom';

export default function ReadPage() {

	const navigate = useNavigate();
	const {tno} = useParams();

	const [queryParams] = useSearchParams();

	const page = queryParams.get('page') ? parseInt(queryParams.get('page')) : 1
	const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 10

	const queryStr = createSearchParams({page:page, size:size}).toString();
	// 쿼리스트링을 페이지가 이동해도 유지할 수 있는 기능을 만들기 위한 함수.
	// 쿼리스트링을 생성해주는 함수.

	console.log(tno);

	const moveToModify = (tno) => {
		
		navigate({
			pathname:`/todo/modify/${tno}`,
			search:queryStr
		}, [tno])

	}

	const moveToList = () => {
		navigate({
			pathname:`/todo/list`,
			search:queryStr
		})
	}
	
	return (
		<div className='text-3xl'>
			Todo Read Page {tno}

			<div>
				<button onClick={() => moveToModify(tno)}>Test Modify</button>
				<button onClick={moveToList}>Test List</button>
			</div>
		</div>
	)
}
